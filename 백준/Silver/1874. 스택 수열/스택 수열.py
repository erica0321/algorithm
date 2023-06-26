class Stack:
    def __init__(self):
        self.stack = []

    def push(self, data):
        data = int(data)
        self.stack.append(data)
    
    def pop(self):
        self.stack.pop()

    def top(self):
        if len(self.stack) != 0:
            return (self.stack[-1])

stack = Stack()
ans = []
now = 1
flag = 0

total = int(input())

for i in range(total):
    num = int(input())

    while now <= num:
        stack.push(now)
        ans.append("+")
        now += 1

    if stack.top() == num:
        stack.pop()
        ans.append("-")
    else:
        flag = 1              
        print("NO") 
        break         

if flag == 0:
    for i in ans:
        print(i)