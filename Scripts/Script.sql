select user(), database ();
desc product ;
desc sale ;

insert into product values
('A001','아메리카노'),
('A002','카푸치노'),
('A003','헤이즐넛'),
('A004','에스프레소'),
('B001','딸기쉐이크'),
('B002','후르츠와인'),
('B003','팥빙수'),
('B004','아이스초코');

select p.product_code, p.product_name, s.price, s.sale_cnt, 
	   round((s.price * s.sale_cnt)-(s.price * s.sale_cnt/11)) as '공급가액', 
       round(s.price * s.sale_cnt/11) as '부가세액', (s.price * s.sale_cnt) as '판매금액', 
       s.margin_rate, round(((s.price * s.sale_cnt)-(s.price * s.sale_cnt/11))*(s.margin_rate*0.01)) as '마진액' 
  from sale s left join product p on s.product_code = p.product_code
order by s.price * s.sale_cnt desc;

select p.product_code, p.product_name, s.price, s.sale_cnt, 
	   round((s.price * s.sale_cnt)-(s.price * s.sale_cnt/11)) as '공급가액', 
       round(s.price * s.sale_cnt/11) as '부가세액', (s.price * s.sale_cnt) as '판매금액', 
       s.margin_rate, round(((s.price * s.sale_cnt)-(s.price * s.sale_cnt/11))*(s.margin_rate*0.01)) as '마진액' 
  from sale s left join product p on s.product_code = p.product_code
order by round(((s.price * s.sale_cnt)-(s.price * s.sale_cnt/11))*(s.margin_rate*0.01)) desc;
