# Limjinlok
## 화면 별 기술 스택
### ContactListFragment

필수 구성 UI: recyclerView, Adapter, viewHolder

구현 기능

-ContactListAdapter를 이용하여 User정보 넘기기

-floatingActionButton 클릭 시 Dialog 띄우기

-빈 별모양 이미지(즐겨찾기) 클릭시 색이 있는 별모양 이미지로 변경

-우측 상단의 버튼을 클릭하면 listView에서 gridView로 전환

-viewPager2와 tapLayout을 이용하여 MyPageFragment로 페이지 전환

---
### ContactDetail

필수 구성 UI: ConstraintLayout, ImageView, Button, Bundle, ScrollView

구현 기능

-ContactListFragment에서 연락처 클릭시 해당 연락처 상세 정보를 띄워줌

(이미지, 이름, 모바일, 블로그, 닉네임 등의 정보)

---
### MyPageFragment

필수 구성 UI: ConstraintLayout, ImageView, Button, ScrollView

구현 기능

-ConstactListAdapter를 이용하여 Bundle로 데이터 넘겨받음

-viewPager2와 tapLayout을 이용하여 ContactListFragment로 페이지 전환

---
### AddContactDialog

필수 구성 UI: Dialog or DialogFragment, EditText, Feature Button

구현 기능

-정보 입력 후 확인 버튼 클릭시 ContactList에 데이터 추가

-이름이나 번호에 공백이 있을 시 다이얼로그 종료

---
## 그 외의 링크들

[구글프레젠테이션](https://docs.google.com/presentation/d/1IO9LXY-BRQ8mZ3WcTBgovA_RzwVTBJFLvqwXfLFKE00/edit?usp=sharing)

[와이어프레임](https://www.figma.com/file/8E7bKKrhFiWkqNVGvdSlgi/%EC%9E%84%EC%A7%84%EB%A1%9D?type=design&node-id=0%3A1&mode=design&t=gfvgVASSlLDYthDc-1)

---
## 개발자
권민석 mindori9097@gmail.com

황일규 ilkyu092@naver.com

조병현 whgg9786@gmail.com

홍현민 hghymin3129@gmail.com

류연주 yeonjoo3751@gmail.com
