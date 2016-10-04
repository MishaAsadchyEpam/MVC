package myapp.hibernateCRUDDao;

import myapp.baseDao.HibernateCDDao;
import myapp.entities.Votes;
import org.springframework.stereotype.Repository;


@Repository
public class VotesHibernateCDDao extends HibernateCDDao<Votes> {
    @Override
    public Votes find(int id)
    {
        return (Votes) getSession().get(Votes.class, id);
    }

    public Votes findVote(int pictureId, int userId)
    {
        return (Votes) getSession().createQuery
                ("from Votes vote where vote.pictureId = :pictureId and vote.userId = :userId")
                .setInteger("pictureId", pictureId)
                .setInteger("userId", userId)
                .uniqueResult();
    }
}