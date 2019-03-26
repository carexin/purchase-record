

## swagger url

http://localhost:9005/swagger-ui.html#/

## supplier

## order_master


## order_detail

名称 goods_name
数量 amount
单价 unit_price
总价 total_price


```mysql
CREATE USER 'purchase_record'@'localhost' IDENTIFIED BY 'purchase_record';
GRANT ALL PRIVILEGES  ON *.* TO 'purchase_record'@'localhost';  

flush privileges;

```

