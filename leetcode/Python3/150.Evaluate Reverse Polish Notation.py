#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-17 10:10:48
@LastEditor: John
@LastEditTime: 2020-07-17 10:11:17
@Discription: 
@Environment: python 3.7.7
'''
# tag: 栈
'''逆波兰就是后缀表达式，在裘宗燕的数据结构中栈那一章也有例子'''
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        pop_list = []
        for i in tokens:
            if i in "+-*/":
                tmp1 = pop_list.pop()
                tmp2 = pop_list.pop()
                pop_list.append(str(int(eval(tmp2+i+tmp1)))) # eval函数
            else:
                pop_list.append(i)
        return int(pop_list[0])