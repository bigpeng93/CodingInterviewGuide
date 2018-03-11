package RecursionAndDynamic.MinCost;

/**
 * 最小编辑代价
 *
 * 给定两个字符串str1和str2，再给定三个整数ic、dc和rc，分别代表插入、删除
 * 和替换一个字符的代价，返回将str1和str2的最小代价。
 *
 * 举例：
 *  str1="abc",str2="adc",ic=5,dc=3,rc=2，
 *  从"abc"编辑到"adc",把'b'替换成'd'代价最小，为2；
 *  str1="abc",str2="adc",ic=5,dc=3,rc=10，
 *  从"abc"编辑到"adc"，先删除'b'再插入'd'代价最小，为8；
 *  str1="abc",str2="abc",ic=5,dc=3,rc=2，
 *  不同编辑了，本来就是一样的字符串，所以返回0。
 */
public class Question {
}
