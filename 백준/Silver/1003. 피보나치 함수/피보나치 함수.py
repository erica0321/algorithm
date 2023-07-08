test_num = int(input())

call_zero = [1, 0]
call_one = [0, 1]

for i in range(2, 41):
    call_zero.append(call_zero[i-1] + call_zero[i-2])
    call_one.append(call_one[i-1] + call_one[i-2])

for i in range(test_num):
    number = int(input())
    print(f"{call_zero[number]} {call_one[number]}")
