xs, ys = map(int, input().split())
xe, ye, dx, dy = map(int, input().split())

#최대공약수 -> dx, dy를 최소로 만들어주기 위해 공약수 찾기
def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a
    
gcd_xy = gcd(dx, dy)
dx = dx // gcd_xy
dy = dy // gcd_xy

def distance(x, y):
    dist = ((xs - x) ** 2 + (ys - y) ** 2) ** 0.5
    return dist

X = xe
Y = ye

#현재에서 정류장 거리가 이동한것에서 정류장 거리보다 크면 이동, 만약 작으면 멈춤
while(distance(X, Y) > distance(X + dx, Y + dy)):
    X += dx
    Y += dy

print(f"{X} {Y}")
