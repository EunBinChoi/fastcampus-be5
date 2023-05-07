1. hashing function을 구현하는 `hashCode()` 메소드가 동일하면 동일한 객체로 판단한다. (X)
    > hashCode가 충돌 날 수 있으므로 hashCode && equals 모두 true 이어야 동일한 객체로 판단함

2. Queue는 마지막에 들어온 객체가 먼저 나가는 후입선출 (LIFO)를 따른다. (X)
   > 먼저 들어온 객체가 먼저 나가는 선입선출 (FIFO)

3. Stack은 먼저 들어온 객체가 먼저 나가는 선입선출 (FIFO)를 따른다. (X)
   > 마지막에 들어온 객체가 먼저 나가는 후입선출 (LIFO)

4. Set은 들어온 순서를 유지하기 위해서 인덱스를 사용한다. (X)
   > Set은 들어온 순서가 유지되지 않음 (인덱스 개념 없어서 Iterator 사용)

5. List는 들어온 순서를 유지하기 위해서 인덱스를 사용한다. (O)
   > List는 들어온 순서가 유지됨
   > 인덱스 사용

6. Set은 객체 중복 정의가 불가능하다. (O)
   > Set은 객체 중복 정의 불가능 (hashCode && equals 모두 true 면 동일한 객체로 판단)

7. 인덱스 개념이 없는 컬렉션은 iterator()를 이용하여 객체를 반복한다. (O)
   > Set, Map 같은 컬렉션의 경우 iterator()를 이용하여 객체를 반복함

8. 컬렉션은 `Index Out Of Bounds` 오류가 발생할 수 있다. (O)
   > 가능, set/remove/add(int index ...) 인 경우 Index Out Of Bounds 오류 발생 가능

9. Map은 key-value 맵핑으로 구성된 Entry 객체를 저장한다. (O)
   > Map은 key-value 쌍을 저장함

10. Map의 key가 중복될 수 있다. (X)
   > key를 통해 value를 접근하기 때문에 key는 중복 불가

11. Map의 value는 중복될 수 있다. (O)
   > value는 중복 가능

12. TreeMap은 key를 기준으로 객체를 정렬하여 삽입한다. (O)
   > TreeMap의 key를 기준으로 객체 정렬하여 삽입함