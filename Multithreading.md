**Thread Lifecycle:**  

NEW → RUNNABLE → (RUNNING) → TIMED\_WAITING / BLOCKED → TERMINATED

Java doesn’t expose RUNNING.

sleep/join/wait → TIMED\_WAITING

join waits for thread to finish.

start() creates new thread.

run() is normal method.



**Thread Methods (Summary):**

start() → creates new thread

run() → normal method

sleep() → TIMED\_WAITING

join() → wait for thread to finish

interrupt() → signals interruption

setPriority() → hint only, not guarantee

yield() → gives chance to others

daemon thread → dies when main/user threads finish



**Synchronization:**

Race condition → multiple threads modify shared data.

Critical section → code accessing shared resource.

synchronized → only one thread enters at a time.

Gives mutual exclusion.

Without synchronized → wrong result.

Method synchronized == synchronized(this).



**Locks (ReentrantLock):**

Lock gives manual control over synchronization.

ReentrantLock → same thread can re-acquire lock.

lock() → waits forever

tryLock() → tries, can fail

tryLock(timeout) → waits limited time

Always unlock in finally block.

Used when more control than synchronized is needed.



**Deadlock:**

Deadlock = two or more threads waiting forever.



**Occurs when:**

Mutual exclusion

Hold and wait

No preemption

Circular wait

Prevention:

Lock resources in same order

Avoid nested locks

Use tryLock with timeout

