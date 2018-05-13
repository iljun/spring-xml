package domain.bbs;

import java.util.List;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 12
 * Time: 오후 4:39
 */
public interface BBSMapper {

    List<BBS> selectAll();

    void create(BBS bbs);

    BBS selectById(Long id);

    void deleted(Long id);

    void update(BBS bbs);
}
