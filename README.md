# 算法索引表 #
包名:问题名
## 一、StackAndQueue:栈和队列 ##
    1.1 DogCatQueue:猫狗队列
    1.2 SortStackByStack:用一个栈实现另一个栈的排序
    1.3 HanoiProblem:用栈来求解汉诺塔问题
    1.4 GetMaxWindow:生成窗口最大值数组
    1.5 MaxTree:构造数组的MaxTree
    1.6 MaxRecSize:求最大子矩阵的大小
    1.7 GetNum:最大值减去最小值小于或等于num的子数组数量
## 二、LinkedQuestion:链表问题 ##
    2.1 PrintCommonPart:打印两个有序链表的公共部分
    2.2 RemoveLastKthNode:在单链表和双链表中删除倒数第K个节点
    2.3 RemoveMidNode:删除链表的中间节点和a/b处的节点
    2.4 RevereseList:反转单向和双向链表
    2.5 ReversePart:反转部分单项链表
    2.6 JosephusKill:环形单链表的约瑟夫问题
    2.7 IsPalindromel:判断一个链表是否为回文结构
    2.8 ListPartition:将单向链表按某值划分成左边小、中间相等、右边大的形式
    2.9 CopyListWithRand:复制含有随机指针节点的链表
    2.10 AddList:两个单链表生成相加链表
    2.11 NodeLoop:两个单链表相交的一系列问题
    2.12 ReverseKNode:将单链表的每K个节点之间逆序
    2.13 RemoveRep:删除无序单链表中值重复出现的节点
    2.14 RemoveValue:在单链表中删除指定值的节点
    2.15 Convert:将搜索二叉树转换成双向链表
    2.16 SelectionSort:单链表的选择排序
    2.17 RemoveNodeWired:一种怪异的节点删除方式
    2.18 InsertNum:向有序的环形单链表中插入新节点
    2.19 Merge:合并两个有序的单链表
    2.20 Relocate:按照左右半区的方式重新组合单链表
## 三、BinaryTree：二叉树问题 ##
 
1. 深度优先遍历：对每一个可能的分支路径深入到不能再深入为止，而且每个结点只能访问一次。要特别注意的是，二叉树的深度优先遍历比较特殊，可以细分为先序遍历、中序遍历、后序遍历。具体说明如下：


    先序遍历：对任一子树，先访问根，然后遍历其左子树，最后遍历其右子树。
    
    中序遍历：对任一子树，先遍历其左子树，然后访问根，最后遍历其右子树。
    
    后序遍历：对任一子树，先遍历其左子树，然后遍历其右子树，最后访问根。

2. 广(宽)度优先遍历：又叫层次遍历，从上往下对每一层依次访问，在每一层中，从左往右（也可以从右往左）访问结点，访问完一层就进入下一层，直到没有结点可以访问为止。　　　

> **二叉树的大部分问题都会转换为对于二叉树的深度优先遍历或者是广度优先遍历问题。**

> **二叉树的深度优先遍历的非递归的通用做法是采用栈，广度优先遍历的非递归的通用做法是采用队列。**

    3.1 OrderRecur:分别用递归和非递归方式实现二叉树先序、中序和后序遍历
	3.2 PrintEdge:打印二叉树的边界节点
	3.3 PrintTree:如何较为直观地打印二叉树
	3.4 SerialOrReconTreeNode:二叉树的序列化和反序列化
	3.5 Morris:遍历二叉树的神级方法
	3.6 GetMaxLength:在二叉树中找到累加和为指定值的最长路径长度
	3.7 找到二叉树中的最大搜索二叉树
	3.8 找到二叉树中符合搜索二叉树条件的最大拓扑结构
	3.9 二叉树的按层打印与ZigZag打印
	3.10 调整搜索二叉树中两个错误的节点
	3.11 判断t1树是否包含t2树全部的拓扑结构