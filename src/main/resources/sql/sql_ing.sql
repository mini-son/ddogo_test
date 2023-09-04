-- ★오늘의 전국 best 맛집/hotplace_name,hotplace_no,jjim,avg_emo_result(4개 테이블 조인)★/소수점 둘째자리까지
with ReviewAverages as (
    select hotplace_no, avg(emo_result) as avg_emo_result
    from emoreview
    group by hotplace_no
)
select h.hotplace_name, h.hotplace_no, count(m.map_no) as jjim,
       format(ra.avg_emo_result,2) as avg_emo_result
from hotplace h
left join mymap m on h.hotplace_no = m.hotplace_no
left join ReviewAverages ra on h.hotplace_no = ra.hotplace_no
where datediff(m.recom_date, now()) = 0
  and m.recom = 'Y'
  and h.hotplace_cate_no = 1
group by h.hotplace_name, h.hotplace_no, ra.avg_emo_result
order by jjim desc
limit 3;

