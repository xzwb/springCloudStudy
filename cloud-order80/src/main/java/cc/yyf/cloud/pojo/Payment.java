package cc.yyf.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("payment")
public class Payment implements Serializable {
    private int id;
    private String serial;
}
