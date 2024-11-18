# java-ladder

자바 사다리 미션 저장소

## 개요

참여자와 상품을 입력 받아 랜덤 사다리를 만들어 참여자와 상품을 연결시켜주는 게임이다.

## 요구사항

### 사람(Person)

- [x] 사람의 이름은 1자 이상 5자 이하여야 한다.

### 참여자(Participant)

- [x] 참여자들은 사다리에서 자신의 위치를 갖고 있다.
- [X] 참여자들은 정해진 라인을 따라 이동한다.

### 참여자들(Participants)

- [x] 참여자들의 이름은 중복이 될 수 없다.
- [x] 각 라인의 출발점에는 하나의 사람만 있을 수 있다.

### 상품(Prize)

- [x] 상품은 금액으로 이루어져 있다.
- [x] 상품의 금액이 값을 표현한다.(vo를 표현할 수 있는 말이 무엇이 있을까?)

### 라인(RowLine)

- [x] 라인들의 각 지점은 오른쪽, 왼쪽, 아래쪽 방향성 중 하나만을 가질 수 있다.
- [x] 라인이 연결성은 겹치지 않아야 한다.
- [x] 라인의 연결 여부는 랜덤으로 결정한다.

### 사다리(Ladder)

- [x] 여러개의 Line이 모여 하나의 사다리를 만든다.

### 사다리 게임(LadderGame)

- [x] 참여자들을 라인 따라 이동해 상품과 최종적으로 연결을 맺는다.
