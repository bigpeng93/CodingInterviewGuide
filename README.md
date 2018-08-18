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
 
1. 深度优先遍历：对每一个可能的分支路径深入到不能再深入为止，而且每个结点只能访问一次。深度优先遍历三种**方法**主要有递归、非递归、Morris遍历。二叉树的深度优先遍历**方式**可以细分为先序遍历、中序遍历、后序遍历。具体说明如下：
   
   
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
	3.7 BiggestSubBST:找到二叉树中的最大搜索二叉树
	3.8 BstTopoSize:找到二叉树中符合搜索二叉树条件的最大拓扑结构
	3.9 PrintByLevelOrZigZag:二叉树的按层打印与ZigZag打印
	3.10 GetTwoErrNodes:调整搜索二叉树中两个错误的节点
	3.11 Contains:判断t1树是否包含t2树全部的拓扑结构
	3.12 IsSubTree:判断t1树是否有与t2树拓扑结构完全相同的子树
	3.13 IsBalance:判断二叉树是否为平衡二叉树
	3.14 IsPostArray:根据后序数组重建搜索二叉树
	3.15 IsBSTOrCBT:判断一棵二叉树是否为搜索二叉树和完全二叉树
	3.16 GenerateTree:通过有序数组生成平衡搜索二叉树
	3.17 GetNextNode:在二叉树中找到一个节点的后继节点
	3.18 LowestAncestor:在二叉树中找到两个节点的最近公共祖先
	3.19 TarjanQuery:Tarjan算法与并查集解决二叉树节点间最近公共祖先的批量查询问题
	3.20 MaxDistance:二叉树节点间的最大距离问题
	3.21 ToTree:先序、中序和后序数组两两结合重构二叉树
	3.22 GetPosArray:通过先序和中序数组生成后序数组
	3.23 NumTree:统计和生成所有不同的二叉树
	3.24 NodeNum:统计完全二叉树的节点数

## 四、RecursionAndDynamic:递归和动态规划 ##

每个包下的OrgQuestion为源问题的解决方法，ExtQue*为由原问题衍生出来的问题

    4.1 FibonacciQuestions:斐波那契系列问题的递归和动态规划
    4.2 MinPathSum:矩阵的最小路径和
    4.3 MinCoins:换钱的最少货币数
    4.4 Coins:换钱的方法数
    4.5 List:最长递增序列
    4.6 Hanoi:汉诺塔问题
    4.7 Lcse:最长公共子序列问题
    4.8 Lcst:最长公共子串问题
    4.9 MinCost:最小编辑代价
    4.10 IsCross:字符串的交错组成
    4.11 MinHP:龙与地下城游戏问题
    4.12 Num:数字字符串转换为字母组合的种数
    4.13 IsValid:表达式得到期望结果的组成种数
    4.14 Win:排成一条线的纸牌博弈问题
    4.15 Jump:跳跃游戏
    4.16 LongestConsecutive:数组中的最长连续序列
    4.17 NQueen:N皇后问题
    
## 大数据和空间限制 ##

    5.1 认识布隆过滤器
    5.2 只有2GB内存在20亿个整数中找到出现次数最多的数
    5.3 40亿个非负整数中找到没出现的数
    5.4 找到100亿个URL中重复的URL以及搜索词汇的top K 问题
    5.5 40亿个非负整数中找到出现两次的数和所有数的中位数
    5.6 一致性哈希算法的基本原理
    
## 位计算 ##
    
    6.1 Change:不用额外变量交换两个整数的值
    6.2 GetMax:不用任何比较判断找出两个数中较大的数
    6.3 Computer:只用位运算不用算数运算实现整数的加减乘除运算
    6.4 Count:整数的二进制表达中有多少个1
    6.5 PrintOddTimesNum:在其他数都出现偶数次的数组中找到出现奇数次的数
    6.6 OnceNum:在其他数都出现K次的数组中找到只出现一次的数
    
## 数组和矩阵问题 ##
    
    7.1 转圈打印矩阵
    7.2 将正方形矩阵顺时针转动90°
    7.3 PrintMatrixZigZag:“之”字形打印矩阵
    7.4 GetMinKNums:找到无序数组中最小的K个数
    7.5 GetMinLength:需要排序的最短子数组长度
    7.6 PrintHalfMajor:在数组中找到出现次数大于N/K的数
    7.7 IsContains:在行列都排好序的矩阵中找数
    7.8 GetLIL:最长的可整合子数组的长度
    7.9 PrintUnique:不重复打印排序数组中相加和为给定值的所有二元组和三元组
    7.10 GetMaxLength:未排序正数数组中累加和为给定值的最长子数组长度
    7.11 MaxLength:未排序数组中累加和为给定值的最长子数组系列问题
    7.12 RandomMaxLength:未排序数组中累加和小于或等于给定值的最长子数组长度
    7.13 计算数组的小和
    7.14 Sort:自然数数组的排序
    7.15 Modify:奇数下标都是奇数或者偶数下标都是偶数
    7.16 ArrayMaxSum:子数组的最大累加和问题
    7.17 MatrixMaxSum:子矩阵的最大累加和问题
    7.18 GetLessIndex:在数组中找到一个局部最小的问题
    7.19 MaxProduct:数组中子数组的最大累乘积
    7.20 PrintTopK:打印N个数组整体最大的Top K
    7.21 SetBorderMap:边界都是1的最大正方形大小
    7.22 不包含本位置值的累乘数组
    7.23 LeftUnique:数组的partition调整
    7.24 求最短通路值
    7.25 数组中未出现的最小正整数
    7.26 数组排序之后相邻数的最大差值
      

