crane_num = int(input())
crane_list = list(map(int, input().split()))
crane_list.sort(reverse = True)

box_num = int(input())
box_list = list(map(int, input().split()))
box_list.sort(reverse = True)

minutes = 0

if box_list[0] > crane_list[0]:
    print(-1)
else:
    while len(box_list) != 0:
        for crane in crane_list:
                for box in box_list:
                    if crane >= box:
                        box_list.remove(box)
                        break
        minutes += 1

    print(minutes)