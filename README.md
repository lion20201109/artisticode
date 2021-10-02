# artisticode
artisticode

请先仔细查看master branch的README.md

操作简要指导:
- fork 之后拉取main分支
- new branch 新的分支(命名规则以题目说明为基准)
- 将artisticode-dependencies install 本地maven仓库
- coding
- push 新的分支
- 请求合并


20211001
## 题目:
小明同学的业务中有很多多线程的操作，部分业务中不同的线程执行时还需要相互关联，但是每个线程无法感知到其他线程池中线程的状态，也无法对其进行操作。为此小明设计了业务线程状态控制器：

## 要求:

1. 对于任意线程均可以注册到控制器中.
2. 获取任意线程的状态和其正在执行的业务线类型.
3. 获取任意线程所在的线程池.
4. 获取软关联的所有线程及其状态

## 提供以下方法

1. static void getCurrentThreadStatus();
