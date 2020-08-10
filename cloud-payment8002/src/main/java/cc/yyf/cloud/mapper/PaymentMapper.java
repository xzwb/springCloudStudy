package cc.yyf.cloud.mapper;

import cc.yyf.cloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") int id);
}
