import sys

class Stack:
    def __init__(self):
        self.stack = []
        self.sum = 0

    def push(self, data):
        data = int(data)
        self.stack.append(data)
    
    def pop(self):
        if len(self.stack) != 0:
            self.stack.pop()
        else:
            print(-1)

    def total(self):
        for i in self.stack :
            self.sum += i
        print(self.sum)


test_num = int(sys.stdin.readline())
stack = Stack()

for i in range(test_num):
    test_data = int(sys.stdin.readline())

    if test_data != 0 :
        stack.push(test_data)
    elif test_data == 0:
        stack.pop()

stack.total()