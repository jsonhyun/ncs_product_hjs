-- 커피판매프로젝트
DROP SCHEMA IF EXISTS ncs_product;

-- 커피판매프로젝트
CREATE SCHEMA ncs_product;

-- 제품
CREATE TABLE ncs_product.product (
	product_code CHAR(4)     NOT NULL COMMENT '제품코드', -- 제품코드
	product_name VARCHAR(20) NULL     COMMENT '제품명' -- 제품명
)
COMMENT '제품';

-- 제품
ALTER TABLE ncs_product.product
	ADD CONSTRAINT PK_product -- 제품 기본키
		PRIMARY KEY (
			product_code -- 제품코드
		);

-- 판매현황
CREATE TABLE ncs_product.sale (
	no           INT     NOT NULL COMMENT '번호', -- 번호
	product_code CHAR(4) NOT NULL COMMENT '제품코드', -- 제품코드
	price        INT     NOT NULL COMMENT '가격', -- 가격
	sale_cnt     INT     NOT NULL COMMENT '판매량', -- 판매량
	margin_rate  INT     NOT NULL COMMENT '마진율' -- 마진율
)
COMMENT '판매현황';

-- 판매현황
ALTER TABLE ncs_product.sale
	ADD CONSTRAINT PK_sale -- 판매현황 기본키
		PRIMARY KEY (
			no -- 번호
		);

ALTER TABLE ncs_product.sale
	MODIFY COLUMN no INT NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 판매현황
ALTER TABLE ncs_product.sale
	ADD CONSTRAINT FK_product_TO_sale -- 제품 -> 판매현황
		FOREIGN KEY (
			product_code -- 제품코드
		)
		REFERENCES ncs_product.product ( -- 제품
			product_code -- 제품코드
		),
	ADD INDEX FK_product_TO_sale (
		product_code ASC -- 제품코드
	);
	
-- 사용자 추가
drop user if exists 'user_ncs_product_hjs'@'localhost';
grant all privileges on ncs_product.* to 'user_ncs_product'@'localhost'
identified by 'rootroot';
flush privileges;