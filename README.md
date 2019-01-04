PS：在生成jar包后，在jar包的MANIFEST.MF文件最下方加入Main-Class: main.Main (冒号后面有空格)才能运行
完成了基本要求，额外要求中没有编写单元测试，战斗过程回放未写完

代码中总共6个包
main包：包含Main函数，初始化图形界面，进入main函数后，有2个对话框，来选择生物阵型，之后再进入战斗窗口。空格开始战斗。

map包：定义了图形的基本格式类，定义对战界面背景，维护了界面棋盘模式，20X15。其中用synchronized修饰棋盘mapIndex的remove，get函数，保证界面棋盘的每个点只有一个生物对象

creature包：3个抽象类，4个实类，creature类抽象类，有badcreature和goodcreature2个抽象子类，badcreature的子类为snakexiezi类和luoluo类，goodcreature类的子类为huluwa类和granpa类
	   4个子类的共同功能在creature类中实现，具体功能在2个抽象父类中实现，具体的成员变量的区别在子类本身中实现。Creature类中静态成员变量GoodOne和BadOne统计蠢货的的生物个数，
	   当该生物死亡或者一方为0时，所有生物线程结束。所有类都有Runnable接口

board包：初始化棋盘模式，定义8个goodcreature类（7个葫芦娃类，1个爷爷类），8个badcreature类（6个啰啰类，2个蛇蝎类），并加载背景信息和16个生物类的具体信息。
	初始化一个线程，将上述信息都加载到窗口中，并用16个线程维护生物类的运行

formation包：总共9个类，定于初始化阵型，formation类对类型进行判断，判断之后交给其余8个类去执行具体的信息

record包：记录战斗信息，写入record1.txt文件。有2个类，Step类包含每个生物每一步的具体信息，Record类包含一个Step的arraylist列

战斗机制：
每个生物先进行x轴判断，若x轴和敌人的距离大于1，就前进，若小于等于1，就上下移动，当和敌人的x，y轴距离的绝对值之和小于1时，就进行战斗，每个生物都有不同的血量blood和不同的攻击力attack，
还有一次暴击doubleattack的机会，当生物血量小于1时，就死亡。其中一方全部阵亡后，比赛结束。

继承：creature类存在2重继承关系
封装：所有类中的所有非静态成员变量都用private或pretected修饰，有public的get和set函数当做对外接口，
多态：以向上转型为主，所有的生物类都用Creature类进行引用





