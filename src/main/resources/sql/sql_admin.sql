-- getUserTotal
select count(user_no)
from user;

-- getRecentUser
select count(user_no)
from user
where timestampdiff(month,join_date,now())<1;

-- hotplaceRank
SELECT
MAX(hp.hotplace_no) AS hotplace_no,
hp.sido,
hp.gugun,
hp.hotplace_name,
hc.hotplace_cate_name,
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

-- newPlaceCnt
 select COUNT(hp.hotplace_no)
from hotplace hp
where exists ( select 1 from mymap mm where mm.hotplace_no = hp.hotplace_no and timestampdiff(month, mm.recom_date,now()) <1);

-- hotplaceTotal
select COUNT(hotplace_no)
from hotplace;

-- emoAvg
select round(avg(emo_result),2)
from emoreview;

-- RecentEmoAvg
select round(avg(er.emo_result),2)
        from emoreview er
        where exists (select 1 from mymap mm where mm.map_no = er.map_no and timestampdiff(month, mm.recom_date,now()) <1);
        
-- nowActiveUser
SELECT COUNT(DISTINCT user_no)
FROM ddogo.mymap
WHERE MONTH(recom_date) = MONTH(CURDATE())
AND YEAR(recom_date) = YEAR(CURDATE());