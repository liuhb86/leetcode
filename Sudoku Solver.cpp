#include <cstring>
#include <set>
#include <deque>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

const int DIM = 3;
const int SIZE = DIM*DIM;
const int NTYPE_BLOCKS = 3;
const int NCELLS = SIZE*SIZE;
const int NBLOCKS = NTYPE_BLOCKS * SIZE;
const char CHAR_EMPTY = '.';

enum BlockType
{
	BLOCK_ROW=0,
	BLOCK_COL=1,
	BLOCK_SQUARE=2,
};

struct Cell;

struct Block{
	BlockType type;
	int index;
	int x;
	int y;
	bool isFilled[SIZE+1];
//	Cell* unfilledCells[SIZE];
//	int nUnfilledCells;
	void reset(){
//		memset(unfilledCells, 0, sizeof(Cell*)*SIZE);
		memset(isFilled, 0, sizeof(bool)*(SIZE+1));
	}
	void fill(Cell* cell);
	void clear(Cell* cell);
};

struct Cell {
	Block* block[NTYPE_BLOCKS];
//	int blockOffset[NTYPE_BLOCKS];
	int number;
	int possibleValues[SIZE];
	int nPossibleValues;
	int numberOffset;
//	int costStamp;
	void reset()
	{
		nPossibleValues =0;
	}
	void fill(int number) {
		this->number = number;
		for (int i=0;i<NTYPE_BLOCKS;++i)
		{
			block[i]->fill(this);
		}
	}
	void clear(){
		for (int i=0;i<NTYPE_BLOCKS; ++i)
		{
			block[i]->clear(this);
		}
		this->number = 0;
	}
	bool canFill(int num)
	{
		for(int i=0;i<NTYPE_BLOCKS; ++i)
		{
			if (block[i]->isFilled[num]) return false;
		}
		return true;
	}
};

void Block::fill(Cell* cell)
{
	isFilled[cell->number] = true;
	//unfilledCells[cell->blockOffset[type]] = NULL;
	//--nUnfilledCells;
}

void Block::clear(Cell* cell)
{
	isFilled[cell->number] = false;
	//unfilledCells[cell->blockOffset[type]] = cell;
	//++nUnfilledCells;
}

struct CellCost
{
	int cost;
	Cell* cell;
//	int costStamp;
	bool operator<(const CellCost c) const{
		return cost< c.cost;
	}
};

class Solution {
public:
	Solution()
	{
		int i;
		for (i=0; i < SIZE; ++i)
		{
			rows[i].type = BLOCK_ROW;
			cols[i].type = BLOCK_COL;
			squares[i].type = BLOCK_SQUARE;
			rows[i].index = i;
			cols[i].index = i;
			squares[i].index = i;
			squares[i].x = i/DIM;
			squares[i].y = i%DIM;
			blocks[i] = rows + i;
			blocks[SIZE+i] = cols +i;
			blocks[2*SIZE+i] = squares + i; 
		}
		for (i=0; i<NCELLS; ++i)
		{
			int row = i/SIZE;
			int col = i%SIZE;
			int square = getSquare(row, col);
			Cell* cell = cells + i;
			cell->block[BLOCK_ROW] = rows + row;
			cell->block[BLOCK_COL] = cols + col;
			cell->block[BLOCK_SQUARE] = squares +square;
//			cell->blockOffset[BLOCK_ROW] = col;
//			cell->blockOffset[BLOCK_COL] = row;
//			cell->blockOffset[BLOCK_SQUARE] = (row%DIM) *DIM+ (col%DIM);
		}
	}

	void init(vector<vector<char> > &board)
	{
//		mCostStamp = 0;
		int i;
//		history.clear();
//		unfilledCells = priority_queue <CellCost>();
//		filledCells.clear();
		for (i =0;i<NBLOCKS;++i) {
			blocks[i]->reset();
		}
		set<Cell*> lUnfilledCells;
		for (i=0;i<SIZE; ++i){
			for (int j=0;j<SIZE;++j){
				int iCell = i*SIZE +j;
				int iSquare = getSquare(i, j);
				Cell* cell = cells +iCell;
				char c = board[i][j];
				if (c != CHAR_EMPTY){
					int num = c -'0';
					cell->fill(num);
				}
				else
				{
					cell->number = 0;
					cell->clear();
					lUnfilledCells.insert(cell);
				}
			}
		}

		/*for(i=0;i<NBLOCKS; ++i){
			int count = 0;
			Block* block= blocks[i];
			for (int j=0;j<SIZE;++j){
				if (block->unfilledCells[j]!=NULL){
					++count;
				}
			}
			block->nUnfilledCells = count;
		}*/

		int nUnfilledCells = lUnfilledCells.size();
		vector<CellCost> cellCosts;
		cellCosts.reserve(nUnfilledCells);
		CellCost cellCost;
		for (set<Cell*>::iterator lIt = lUnfilledCells.begin(); lIt!= lUnfilledCells.end(); ++lIt)
		{
			Cell* cell = *lIt;
			cell->nPossibleValues = 0;
			for (int i=1;i<=SIZE; ++i){
				if (cell->canFill(i))
				{
					cell->possibleValues[(cell->nPossibleValues)++]=i;
				}
			}
			cellCost.cost = cell->nPossibleValues;
			cellCost.cell = cell;
			cellCosts.push_back(cellCost);
		}
		sort(cellCosts.begin(), cellCosts.end());

		unfilledCells.resize(nUnfilledCells);
		for (i = 0; i<nUnfilledCells; ++i)
		{
			unfilledCells[i] = cellCosts[i].cell;
		}
	}

    void solveSudoku(vector<vector<char> > &board) {
        init(board);
		int i;

		if (unfilledCells.size() == 0) return;
		Cell** pCells = &unfilledCells[0];
		int totalCell = unfilledCells.size();
		int curCell = 0;
		bool backSearch = false;
		while(curCell >=0 && curCell<totalCell)
		{
			Cell* pCell = pCells[curCell];
			int iNum;
			if (backSearch)
			{
				iNum = pCell->numberOffset + 1;
				pCell->clear();
			}
			else
			{
				iNum = 0;
			}

			for(;iNum < pCell->nPossibleValues;++iNum)
			{
				int num = pCell->possibleValues[iNum];
				if (pCell->canFill(num))
				{
					pCell->numberOffset = iNum;
					pCell->fill(num);
					backSearch = false;
					/*if (curCell<10)
					{
						for (int i=0; i<=curCell; ++i)
						{
							cout<<pCells[i]->number;
						}
						cout<<endl;
					}*/
					++curCell;
					goto NEXT_ITER;
				}
			}
			backSearch = true;
			--curCell;
NEXT_ITER:
			;
		}
		if (curCell < 0)// not solvable
		{
			return;
		}
		for(i=0;i<totalCell;++i)
		{
			Cell* pCell = pCells[i];
			int row = pCell->block[BLOCK_ROW]->index;
			int col = pCell->block[BLOCK_COL]->index;
			board[row][col] = '0' + pCell->number;
		}
		return;
    }

private:
	int getSquare(int row, int col)
	{
		return (row/DIM)*DIM+(col/DIM);
	}
	Block rows[SIZE];
	Block cols[SIZE];
	Block squares[SIZE];
	Block* blocks[NBLOCKS];
	//deque<Cell*> history;
	//priority_queue<CellCost> unfilledCells;
	vector<Cell*> unfilledCells;
	//set<Cell*> filledCells;
	Cell cells[NCELLS];
//	int mCostStamp;
public:
	static void main()
	{
		char* input[] = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		vector<vector<char> > board;
		board.resize(SIZE);
		int i;
		for (i=0; i<SIZE; ++i)
		{
			board[i].resize(SIZE);
			for (int j=0;j<SIZE; ++j)
			{
				board[i][j] = input[i][j];
			}
		}
		Solution s;
		s.solveSudoku(board);
		cout<<"Solution:"<<endl;
		for (i=0;i<SIZE; ++i)
		{
			for (int j=0;j<SIZE;++j)
			{
				cout<<board[i][j];
			}
			cout<<endl;
		}
	}
};
