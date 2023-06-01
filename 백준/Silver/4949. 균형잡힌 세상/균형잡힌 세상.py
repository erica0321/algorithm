import sys

class Stack:
    def __init__(self):
        self.stack = []

    def push(self, data):
        data = str(data)
        self.stack.append(data)
    
    def pop(self):
        if len(self.stack) != 0:
            self.stack.pop()
        else:
            return -1
    
    def len(self):
        return len(self.stack)
    
    def peek(self):
        if len(self.stack) != 0:
            return self.stack[-1]
        else:
            return -1
    
def balance(test_data):
    result=True
    for data in test_data:
        if  data == "(" or data == "[" :
            stack.push(data)
        elif data == ")":
            if stack.len() == 0 or stack.peek() == "[":
                result = False
                break
            elif stack.peek() == "(" :
                stack.pop()
        elif data == "]":
            if stack.len() == 0 or stack.peek() == "(" :
                result = False
                break
            elif stack.peek() == "[" :
                stack.pop()
    if stack.len() == 0 and result == True:
        print('yes')
    else:
        print('no') 


while(True):
    test_data = input()
    if test_data == ".":
        break

    stack = Stack()
    balance(test_data)

    result=True