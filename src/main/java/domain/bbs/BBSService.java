package domain.bbs;

import java.util.List;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 12
 * Time: 오후 3:33
 */
public interface BBSService {

    List<BBS> selectAll();

    BBS selectById(Long id);

    void create(BBS bbs);

    BBS update(BBS bbs);

    void deleted(Long id);
}
