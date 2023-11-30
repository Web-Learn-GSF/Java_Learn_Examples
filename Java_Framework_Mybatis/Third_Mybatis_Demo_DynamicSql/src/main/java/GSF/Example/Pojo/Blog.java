package GSF.Example.Pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Blog implements Serializable {

    private static final long serialVersionUID = 2498811797673776891L;
    private int id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}
