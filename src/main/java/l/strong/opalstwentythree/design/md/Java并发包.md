## ReentrantLock
可重入锁

几个重要方法：
- **lock()** : 获得锁，如果锁已经被占用，则等待
- **lockInterruptibly()** : 获得锁，但优先响应中断
- **tryLock()** : 尝试获得锁，如果成功，则返回true，失败返回false，此方法不等待，立即返回
- **tryLock(long time, TimeUnit unit)** : 在给定时间内尝试获得锁
- **unLock()** : 释放锁

重入锁的实现。聚焦在Java层面，主要包含三个要素：
 - 原子状态，原子状态使用CAS操作来存储当前锁的状态，判断锁是否已经被别的线程持有了
 - 等待队列，所有未请求到锁的线程进入等待队列等待，有线程释放锁之后，系统从等待队列唤醒一个线程，继续工作
 - 阻塞原语（park）和unpark（），用来挂起和恢复线程，未得到锁的线程会被挂起。
## Condition
可重入锁的搭档，通过lock接口的的new condition()方法获得，使用与Object.wait()和Object.notify()相似，可以让
线程在合适时间等待，或在某个特定的时刻得到通知。
函数：
```java
 void await() throws InterruptedException;
 void awaitUninterruptibly()
 long awaitNanos(long nanosTimeout) throws InterruptedException;
 boolean await(long timeout, TimeUnit unit) throws InterruptedException;
 boolean awaitUntil(Date deadline) throws InterruptedException;
 void singal()
 void singalAll()
```

## 信号量
允许多个线程同时访问
```java
public Semaphore(int permits)
public Semaphore(int permits,boolean fair) 第二个参数指定是否公平
```
信号量是对锁的拓展，无论是内部锁Synchronized还是重入锁ReentrantLock，一次都只允许一个线程访问一个资源，但信号量却可以
指定多个线程，同时访问某一个资源。permits是信号量的准入数。

几个重要方法：
```java
public void acquire()
public void acquireUninterruptibly()
public void tryAcquire()
public void tryAcquire(long timeout, TimeUnit unit)
public void release()
```
申请信号量使用acquire()操作，离开时务必使用release()释放信号量，如果发生信号量泄露（申请但未释放），可进入临界区的线程就会越来越少，直到所有的线程都不可访问。

## ReadWriteLock 读写锁
假如A1 A2 A3 进行写操作，B1 B2 B3进行读操作，如果使用重入锁或者内部锁，从理论上
所有读之间、读写之间、写之间都是串行操作，当B1 进行读取时，B2 B3都要等待锁，由于读实际不会更改数据，所以会造成资源浪费，所以引入读写分离的读写锁。

在多个读操作中，还需要

|   | 读  | 写  |
|---|----|----|
| 读 | 非阻塞 | 阻塞 |
| 写 | 阻塞 | 阻塞 |

## CountDownLatch 倒计数器

