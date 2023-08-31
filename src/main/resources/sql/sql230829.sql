insert 
    into
        ddogo.emoreview
        (review_no, map_no, hotplace_no, review,emo_result) 
    values
        (1, 1, 1, '치킨맛있어요','80.55');
        
insert into
hotplace_cate
(hotplace_cate_no, hotplace_cate_name) 
values(2,'카페');

insert into
hotplace
(hotplace_no,sido,gugun,hotplace_name,address,hotplace_cate_no) 
values(1,'서울시','강남구','굽네치킨 역삼1동점','서울 강남구 역삼로 129 LK',1);

insert into
mymap
(map_no,hotplace_no,user_no,recom,map_memo,recom_date)
values(2,1,99,'Y','또가자',now());

insert into
user
(user_no,user_name,user_id,BIRTH,gender,joinDate,email,pwd)
values('99','홍길동','hong',991212,'남',230828,'hong@naver.com',1234);

insert into
ddogo.emoreview(review_no, map_no, hotplace_no, review) 
values(3, 1, 1, 'good');

update emoreview
set map_no='1',hotplace_no='1',review='good',emo_result='78.0'
where review_no='3';






-- 이번달 강남구 맛집 3개(원본.변경해야함)
select distinct h.hotplace_name
from ddogo.hotplace h, ddogo.mymap m
where timestampdiff(month,m.recom_date ,now()) <=0 and h.gugun="강남구" and h.hotplace_cate_no=1
order by (select count(map_no) from ddogo.mymap where recom='Y') desc limit 10;

select hotplace_name from ddogo.mymap where recom='Y';

-- 찜수가 많은 순서대로
select hotplace_no, count(map_no) jjim from ddogo.mymap where recom='y' group by hotplace_no order by jjim desc limit 10;
select hotplace_no from mymap where recom='y' group by hotplace_no order by count(map_no) desc limit 10;

-- 이번달 찜수가 많은 순서대로
select hotplace_no, count(map_no) jjim 
from ddogo.mymap where recom='y' and timestampdiff(month,recom_date ,now()) <=1
group by hotplace_no order by jjim 
desc limit 10;

-- 오늘 찜수가 많은 순서대로
select distinct map_no,hotplace_no
from mymap
where timestampdiff(day,recom_date,now())=0;

-- 오늘 찜수가 많은 순서대로,hotplace.hotplace_name 뿌려주기*******★★★★★
select h.hotplace_name, count(m.map_no) as jjim
from hotplace h
left join mymap m on h.hotplace_no = m.hotplace_no
where timestampdiff(day, m.recom_date, now()) = 0
  and m.recom = 'Y'
  and h.hotplace_cate_no = 1
group by h.hotplace_name
order by jjim desc limit 3;

-- ★★★★★
select h.hotplace_name, h.hotplace_no,count(m.map_no) as jjim
from hotplace h
left join mymap m on h.hotplace_no = m.hotplace_no
where timestampdiff(day, m.recom_date, now()) = 0
  and m.recom = 'Y'
  and h.hotplace_cate_no = 1
group by h.hotplace_name, h.hotplace_no
order by jjim desc limit 3;



select distinct h.hotplace_name
from ddogo.hotplace h, ddogo.mymap m
where timestampdiff(month,m.recom_date ,now()) <=0 and m.recom='Y' and h.hotplace_cate_no=1
order by (select count(map_no) from ddogo.mymap where recom='Y') desc limit 10;


select count(map_no) from mymap where recom='Y';

-- 이번달 강남구 맛집 3개
select distinct h.hotplace_name
from hotplace h
left join mymap m
on h.hotplace_no=m.hotplace_no
where timestampdiff(month,m.recom_date ,now()) <=1 and h.gugun='강남구' and h.hotplace_cate_no=1;

-- 이번달 전국 맛집 3개
select distinct h.hotplace_name
from hotplace h
left join mymap m
on h.hotplace_no=m.hotplace_no
where timestampdiff(month,m.recom_date ,now()) <=1 and h.hotplace_cate_no=1;

-- 또갈 3개 맵 조인
select distinct h.hotplace_no,h.hotplace_name,h.gugun,m.hotplace_no,m.recom,m.recom_date,h.hotplace_cate_no
from hotplace h left join mymap m
on h.hotplace_no=m.hotplace_no left join emoreview e
on e.map_no=m.map_no
where m.recom='Y';

-- 또갈 3개 맵 조인(hotplace,mymap,emoreview)
select distinct h.hotplace_no,h.hotplace_cate_no,h.sido,h.gugun,m.recom,m.recom_date,e.review,e.emo_result
from hotplace h left join mymap m
on h.hotplace_no=m.hotplace_no left join emoreview e
on e.map_no=m.map_no;


  SELECT DISTINCT h.hotplace_name
FROM hotplace h
LEFT JOIN mymap m ON h.hotplace_no = m.hotplace_no
LEFT JOIN (
    SELECT hotplace_no
    FROM mymap
    WHERE recom = 'y'
    GROUP BY hotplace_no
    ORDER BY COUNT(map_no) DESC
    LIMIT 10
) top_hotplaces ON h.hotplace_no = top_hotplaces.hotplace_no
WHERE TIMESTAMPDIFF(MONTH, m.recom_date, NOW()) <= 1
    AND h.gugun = "강남구"
    AND h.hotplace_cate_no = 1
    AND top_hotplaces.hotplace_no IS NOT NULL;



select h.hotplace_name
from ddogo.hotplace h, ddogo.mymap m
where timestampdiff(month,m.recom_date ,now()) <=1 and h.gugun="송파구" and h.hotplace_cate_no=1
order by (select count(map_no) from ddogo.mymap where recom='Y') desc limit 3;



-- 강남 3구 hot맛집(이름만)
select h.hotplace_name
from ddogo.hotplace h, ddogo.mymap m
where h.hotplace_cate_no=1
order by (select count(m.map_no) from ddogo.mymap where recom='Y') desc limit 3;

-- 이번달 강남구 맛집 3개,가게별 감정분석 점수 평균 보여주기
select h.hotplace_name
from ddogo.hotplace h, ddogo.mymap m
where timestampdiff(month,m.recom_date ,now()) <=1 and h.gugun='강남구' and h.hotplace_cate_no=1
order by (select count(map_no) from ddogo.mymap where recom='Y') desc limit 3;

-- 가게별 감정분석 점수 평균
select avg(emoreview.emo_result)
from emoreview
where hotplace_no=1;



select *
from ddogo.hotplace h, ddogo.mymap m
where timestampdiff(month,m.recom_date ,now()) <=1 and h.gugun='강남구' and h.hotplace_cate_no=1;

-- 구군에 강남이 들어어가는 hotplace_name
select hotplace_name
from hotplace
where hotplace.gugun like '%강남%';

-- 이번달 추전
select *
from mymap
where timestampdiff(month,recom_date ,now())<1;


select hotplace_no
from hotplace
where hotplace_no in (select hotplace_no from mymap where recom='Y' group by hotplace_no order by count(recom) desc);


insert all
into mymap values(hotplace_no=3,user_no=95,recom='Y',recom_date=NOW())
into emoreview values(review='또가고싶어요',emo_result=95)
select *
from dual;

-- hotplace의 정보와 해당 hotplace에 대한 추천 수 및 감정 결과의 평균을 계산하고 그룹화한 결과를 반환
 SELECT
MAX(hp.hotplace_no) AS hotplace_no,
hp.sido,hp.gugun,hp.hotplace_name,hc.hotplace_cate_name,
SUM(CASE WHEN mm.recom = 'Y' THEN 1 ELSE 0 END) AS recom_count,
AVG(COALESCE(er.emo_result, 0)) AS emo_result
FROM
hotplace hp
JOIN
hotplace_cate hc ON hp.hotplace_cate_no = hc.hotplace_cate_no
LEFT JOIN
mymap mm ON hp.hotplace_no = mm.hotplace_no
LEFT JOIN
emoreview er ON mm.map_no = er.map_no AND mm.hotplace_no = er.hotplace_no
GROUP BY
hp.sido, hp.gugun, hp.hotplace_name, hc.hotplace_cate_name;



