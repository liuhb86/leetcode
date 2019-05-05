object Solution {
  def leastInterval(tasks: Array[Char], n: Int): Int = {
    val taskCount = Array.fill(26)(0)
    for (t <- tasks) {
      taskCount(t - 'A') += 1
    }
    val interval = n + 1
    val lastTaskTime = Array.fill(26)(-interval)
    var taskLeft = tasks.length
    var currentTime = 0
    var taskTypes = (0 until 26).filter(taskCount(_) > 0)
    while(taskLeft > 0) {
      val latestTime = currentTime - n
      val candidate = taskTypes.filter(lastTaskTime(_) < latestTime)
      if (candidate.isEmpty) {
        currentTime = taskTypes.map(lastTaskTime).min + interval
      } else {
        val nextTask = candidate.maxBy(taskCount)
        taskCount(nextTask) -= 1
        if (taskCount(nextTask) == 0) taskTypes = taskTypes.filter(_ != nextTask)
        lastTaskTime(nextTask) = currentTime
        taskLeft -= 1
        currentTime +=1
      }
    }
    currentTime
  }
}