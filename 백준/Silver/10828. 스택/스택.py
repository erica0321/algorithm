import sys

class Stack:
    def __init__(self):
        self.stack = []

    def push(self, data):
        data = int(data)
        self.stack.append(data)
    
    def pop(self):
        if len(self.stack) != 0:
            print(self.stack.pop())
        else:
            print(-1)
    
    def size(self):
        print(len(self.stack))
    
    def empty(self):
        if len(self.stack) != 0:
            print(0)
        else:
            print(1)

    def top(self):
        if len(self.stack) != 0:
            print(self.stack[-1])
        else:
            print(-1)

test_num = int(sys.stdin.readline())
stack = Stack()

for i in range(test_num):
    test_data = sys.stdin.readline()
    test_data = test_data.split()

    if(test_data[0] == "push"):
        stack.push(test_data[1])
    elif(test_data[0] == "pop"):
        stack.pop()
    elif(test_data[0] == "top"):
        stack.top()
    elif(test_data[0] == "empty"):
        stack.empty()
    elif(test_data[0] == "size"):
        stack.size()
