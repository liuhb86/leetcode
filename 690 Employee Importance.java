/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e: employees) {
            map.put(e.id, e);
        }
        return getImp(map.get(id), map);
    }
    
    int getImp(Employee emp, Map<Integer, Employee> map) {
        int imp = emp.importance;
        for (int s: emp.subordinates) {
            imp = imp + getImp(map.get(s), map);
        }
        return imp;
    }
}