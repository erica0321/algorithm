import sys

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Queue:
    def __init__(self):
        self.head = None
        self.rear = None
        self.count = 0

    def push(self, data):                           #enqueue
        new_node = Node(data)                        #node 생성

        if self.head is None:                      #큐가 비어있을 시 enqueue 방법
            self.head = new_node
            self.rear = new_node
        else:
            self.rear.next = new_node               #큐가 비어있지 않을 때 enqueue 방법
            self.rear = new_node
        
        self.count += 1

    def pop(self):                                  #dequeue
        if self.count==0 :                            #큐가 비어있을 때 pop 불가능
            print(-1)
            return

        now = self.head
        self.head = self.head.next
        self.count -= 1

        print(now.data)
    
    def empty(self):
        if self.count==0:
            print(1)
        else:
            print(0)

    def size(self):
        print(self.count)

    def front(self):
        if self.count == 0:
            print(-1)
        else:
            print(self.head.data)

    def back(self):
        if self.count == 0:
            print(-1)
        else:
            print(self.rear.data)

test_num = int(sys.stdin.readline())
queue = Queue()

for i in range(test_num):
    test_data = sys.stdin.readline()
    test_data = test_data.split()

    if(test_data[0] == "push"):
        queue.push(test_data[1])
    elif(test_data[0] == "pop"):
        queue.pop()
    elif(test_data[0] == "front"):
        queue.front()
    elif(test_data[0] == "back"):
        queue.back()
    elif(test_data[0] == "empty"):
        queue.empty()
    elif(test_data[0] == "size"):
        queue.size()