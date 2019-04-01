/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ public class ThreadPool
/*     */ {
/*     */   private static final long IDLE_TIMEOUT = 60000L;
/*     */   private String name;
/*     */   private int minsize;
/*     */   private int maxsize;
/*  12 */   private int nextWorkerId = 0;
/*  13 */   private LinkedList pool = new LinkedList();
/*     */ 
/*     */   protected ThreadPool() {
/*  16 */     this("PooledThread");
/*     */   }
/*     */ 
/*     */   protected ThreadPool(String name) {
/*  20 */     this(name, 0, 10);
/*     */   }
/*     */ 
/*     */   protected ThreadPool(String name, int minsize, int maxsize) {
/*  24 */     this.name = name;
/*  25 */     this.minsize = minsize;
/*  26 */     this.maxsize = maxsize;
/*     */   }
/*     */ 
/*     */   public synchronized void run(Runnable runner)
/*     */   {
/*  32 */     if (runner == null)
/*  33 */       throw new NullPointerException();
/*     */     Worker worker;
/*     */     Worker worker;
/*  36 */     if (!this.pool.isEmpty()) {
/*  37 */       worker = (Worker)this.pool.removeFirst();
/*     */     } else {
/*  39 */       worker = new Worker(this.name + "-" + ++this.nextWorkerId, null);
/*  40 */       worker.start();
/*     */     }
/*     */ 
/*  43 */     worker.wakeup(runner);
/*     */   }
/*     */ 
/*     */   private synchronized boolean notifyTimeout(Worker worker) {
/*  47 */     if (worker.runner != null) {
/*  48 */       return false;
/*     */     }
/*  50 */     if (this.pool.size() > this.minsize) {
/*  51 */       this.pool.remove(worker);
/*  52 */       return true;
/*     */     }
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */   private synchronized boolean notifyFree(Worker worker) {
/*  58 */     if (this.pool.size() < this.maxsize) {
/*  59 */       this.pool.addLast(worker);
/*  60 */       return false;
/*     */     }
/*  62 */     return true;
/*     */   }
/*     */ 
/*     */   class Worker extends Thread {
/*  66 */     Runnable runner = null;
/*     */ 
/*     */     private Worker(String name) {
/*  69 */       super();
/*     */     }
/*     */ 
/*     */     private synchronized void wakeup(Runnable runner) {
/*  73 */       this.runner = runner;
/*  74 */       notify();
/*     */     }
/*     */ 
/*     */     // ERROR //
/*     */     public void run()
/*     */     {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: dup
/*     */       //   2: astore_1
/*     */       //   3: monitorenter
/*     */       //   4: aload_0
/*     */       //   5: getfield 17\011com/sinosoft/banklns/utility/ThreadPool$Worker:runner\011Ljava/lang/Runnable;
/*     */       //   8: ifnonnull +14 -> 22
/*     */       //   11: aload_0
/*     */       //   12: ldc2_w 34
/*     */       //   15: invokevirtual 36\011java/lang/Object:wait\011(J)V
/*     */       //   18: goto +4 -> 22
/*     */       //   21: astore_2
/*     */       //   22: aload_1
/*     */       //   23: monitorexit
/*     */       //   24: goto +6 -> 30
/*     */       //   27: aload_1
/*     */       //   28: monitorexit
/*     */       //   29: athrow
/*     */       //   30: aload_0
/*     */       //   31: getfield 17\011com/sinosoft/banklns/utility/ThreadPool$Worker:runner\011Ljava/lang/Runnable;
/*     */       //   34: ifnonnull +15 -> 49
/*     */       //   37: aload_0
/*     */       //   38: getfield 12\011com/sinosoft/banklns/utility/ThreadPool$Worker:this$0\011Lcom/sinosoft/banklns/utility/ThreadPool;
/*     */       //   41: aload_0
/*     */       //   42: invokestatic 40\011com/sinosoft/banklns/utility/ThreadPool:access$0\011(Lcom/sinosoft/banklns/utility/ThreadPool;Lcom/sinosoft/banklns/utility/ThreadPool$Worker;)Z
/*     */       //   45: ifeq -45 -> 0
/*     */       //   48: return
/*     */       //   49: aload_0
/*     */       //   50: getfield 17\011com/sinosoft/banklns/utility/ThreadPool$Worker:runner\011Ljava/lang/Runnable;
/*     */       //   53: invokeinterface 46 1 0
/*     */       //   58: goto +45 -> 103
/*     */       //   61: astore_1
/*     */       //   62: aload_1
/*     */       //   63: invokevirtual 50\011java/lang/Exception:printStackTrace\011()V
/*     */       //   66: aload_0
/*     */       //   67: aconst_null
/*     */       //   68: putfield 17\011com/sinosoft/banklns/utility/ThreadPool$Worker:runner\011Ljava/lang/Runnable;
/*     */       //   71: aload_0
/*     */       //   72: getfield 12\011com/sinosoft/banklns/utility/ThreadPool$Worker:this$0\011Lcom/sinosoft/banklns/utility/ThreadPool;
/*     */       //   75: aload_0
/*     */       //   76: invokestatic 55\011com/sinosoft/banklns/utility/ThreadPool:access$1\011(Lcom/sinosoft/banklns/utility/ThreadPool;Lcom/sinosoft/banklns/utility/ThreadPool$Worker;)Z
/*     */       //   79: ifeq -79 -> 0
/*     */       //   82: return
/*     */       //   83: astore_2
/*     */       //   84: aload_0
/*     */       //   85: aconst_null
/*     */       //   86: putfield 17\011com/sinosoft/banklns/utility/ThreadPool$Worker:runner\011Ljava/lang/Runnable;
/*     */       //   89: aload_0
/*     */       //   90: getfield 12\011com/sinosoft/banklns/utility/ThreadPool$Worker:this$0\011Lcom/sinosoft/banklns/utility/ThreadPool;
/*     */       //   93: aload_0
/*     */       //   94: invokestatic 55\011com/sinosoft/banklns/utility/ThreadPool:access$1\011(Lcom/sinosoft/banklns/utility/ThreadPool;Lcom/sinosoft/banklns/utility/ThreadPool$Worker;)Z
/*     */       //   97: ifeq +4 -> 101
/*     */       //   100: return
/*     */       //   101: aload_2
/*     */       //   102: athrow
/*     */       //   103: aload_0
/*     */       //   104: aconst_null
/*     */       //   105: putfield 17\011com/sinosoft/banklns/utility/ThreadPool$Worker:runner\011Ljava/lang/Runnable;
/*     */       //   108: aload_0
/*     */       //   109: getfield 12\011com/sinosoft/banklns/utility/ThreadPool$Worker:this$0\011Lcom/sinosoft/banklns/utility/ThreadPool;
/*     */       //   112: aload_0
/*     */       //   113: invokestatic 55\011com/sinosoft/banklns/utility/ThreadPool:access$1\011(Lcom/sinosoft/banklns/utility/ThreadPool;Lcom/sinosoft/banklns/utility/ThreadPool$Worker;)Z
/*     */       //   116: ifeq -116 -> 0
/*     */       //   119: return
/*     */       //
/*     */       // Exception table:
/*     */       //   from\011to\011target\011type
/*     */       //   11\01118\01121\011java/lang/InterruptedException
/*     */       //   4\01124\01127\011finally
/*     */       //   27\01129\01127\011finally
/*     */       //   49\01158\01161\011java/lang/Exception
/*     */       //   49\01166\01183\011finally
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.ThreadPool
 * JD-Core Version:    0.6.0
 */