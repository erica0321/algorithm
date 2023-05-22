test_num = int(input())

for i in range(test_num):
    stack = []
    data=input()

    for j in data:
        if j == '(':
            stack.append(j)
        elif j == ')':
            if stack:
                stack.pop()
            else:
                print("NO")
                break

    else:
        if not stack: 
           print("YES")
        else:
            print("NO")