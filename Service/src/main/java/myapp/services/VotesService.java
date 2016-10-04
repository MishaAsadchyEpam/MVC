package myapp.services;

import myapp.entities.Images;
import myapp.entities.Votes;
import myapp.hibernateCRUDDao.VotesHibernateCDDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class VotesService {

    @Autowired
    private VotesHibernateCDDao voteshibernatedao;

    @Autowired
    private ImagesService imageService;

    public int saveOrDelete(int pictureId, int userId)
    {

        Votes votes = voteshibernatedao.findVote(pictureId, userId);

        Images image = imageService.find(pictureId);

        if (votes == null)
        {
            voteshibernatedao.save(new Votes(pictureId, userId));
            image.increment();
        }
        else
        {
            voteshibernatedao.delete(votes.getVoteId());
            image.decrement();
        }

        imageService.update(image);

        return image.getVotesNumber();
    }

}