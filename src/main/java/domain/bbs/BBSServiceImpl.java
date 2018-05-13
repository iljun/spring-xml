package domain.bbs;

import java.util.List;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 12
 * Time: 오후 3:33
 */
public class BBSServiceImpl implements BBSService{

    private BBSMapper bbsMapper;

    public void setBbsMapper(BBSMapper bbsMapper){
        this.bbsMapper = bbsMapper;
    }

    @Override
    public List<BBS> selectAll() {
        return bbsMapper.selectAll();
    }

    @Override
    public BBS selectById(Long id) {
        return bbsMapper.selectById(id);
    }

    @Override
    public void create(BBS bbs) {
        bbsMapper.create(bbs);
    }

    @Override
    public BBS update(BBS bbs) {
        bbsMapper.update(bbs);
        return bbs;
    }

    @Override
    public void deleted(Long id) {
        bbsMapper.deleted(id);
    }
}
