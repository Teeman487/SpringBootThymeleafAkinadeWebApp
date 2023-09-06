package net.adebusoyeteeman.springbootthymeleafakinadewebapp.service.Impl;

import net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto.TpostDto;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.entity.Tpost;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.entity.User;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.mapper.TpostMapper;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.repository.TpostRepository;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.repository.UserRepository;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.service.TpostService;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.util.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service   // this annottaion indicates that TpostServiceImpl is a spring service class,

public class TpostServiceImpl implements TpostService {

    private TpostRepository tpostRepository;
    private UserRepository userRepository;  // 105 Refactor Create Post Feature for LoggedIn User
// write the code to get the login User id from the spring security

    public TpostServiceImpl(TpostRepository tpostRepository, UserRepository userRepository) {
        this.tpostRepository = tpostRepository; this.userRepository = userRepository;
    }

    @Override
    public List<TpostDto> findAllPosts() {
        List<Tpost> tposts = tpostRepository.findAll();  // CRUD operation
        /*return tposts.stream().map((tpost) -> TpostMapper.mapToTpostDto(tpost))
                .collect(Collectors.toList());*/
        return tposts.stream().map(TpostMapper::mapToTpostDto)
                .collect(Collectors.toList());
    }


    //107 Refactor List Posts Feature to List Only LoggedIn Use
    @Override
    public List<TpostDto> findPostByUser() {

        String email = SecurityUtils.getCurrentUser().getUsername();
        User createdBy = userRepository.findByEmail(email);
        Long userId = createdBy.getId();
        List<Tpost> tposts = tpostRepository.findPostsByUser(userId);
        return tposts.stream()
                .map((post) -> TpostMapper.mapToTpostDto(post))
                .collect(Collectors.toList());
    }




   /* @Override
    public void createYourPost(TpostDto tpostDto) {
        Tpost tpost = TpostMapper.mapToTpost(tpostDto);  // map model to entity; reverse case
        tpostRepository.save(tpost); // intention is to simply submit; reverse
    }*/

    // 105 Refactor Create Post Feature for LoggedIn User
// write the code to get the login User id from the spring security
    @Override
    public void createYourPost(TpostDto tpostDto) {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User user = userRepository.findByEmail(email);
        Tpost tpost = TpostMapper.mapToTpost(tpostDto);  // map model to entity; reverse case
        tpost.setCreatedBy(user);
        tpostRepository.save(tpost); // intention is to simply submit; reverse
    }
    @Override
    public TpostDto findPostById(Long tpostId) {
        Tpost tpost = tpostRepository.findById(tpostId).get();
        return TpostMapper.mapToTpostDto(tpost); // entity map to Dto
    }
   /* @Override
    public void updatePost(TpostDto tpostDto) {
        Tpost tpost = TpostMapper.mapToTpost(tpostDto);
        tpostRepository.save(tpost);

    }*/
   // 106 Refactor Update Post FeatureFor Logged In User
   @Override
   public void updatePost(TpostDto tpostDto) {
       String email = SecurityUtils.getCurrentUser().getUsername();
       User createdBy = userRepository.findByEmail(email);
       Tpost tpost = TpostMapper.mapToTpost(tpostDto);
       tpost.setCreatedBy(createdBy);
       tpostRepository.save(tpost);

   }
    @Override
    public void deletePost(Long tpostId) {
        tpostRepository.deleteById(tpostId);
    }
    @Override
    public TpostDto findPostByUrl(String tpostUrl) {
        Tpost tpost = tpostRepository.findByUrl(tpostUrl).get(); // to get post object
        return TpostMapper.mapToTpostDto(tpost);
    }

    @Override
    public List<TpostDto> searchPosts(String query) {
        List<Tpost> tposts =tpostRepository.searchPosts(query);
        // convert list of posts entity to list of postDtos using stream
        return  tposts.stream()
                .map(TpostMapper::mapToTpostDto).
                collect(Collectors.toList());

    }

}







/*@Service   // this annottaion indicates that TpostServiceImpl is a spring service class,

public class TpostServiceImpl implements TpostService {

    private TpostRepository tpostRepository;

    public TpostServiceImpl(TpostRepository tpostRepository) {
        this.tpostRepository = tpostRepository;
    }

    @Override
    public List<TpostDto> findAllPosts() {
        List<Tpost> tposts = tpostRepository.findAll();
        *//*return tposts.stream().map((tpost) -> TpostMapper.mapToTpostDto(tpost))
                .collect(Collectors.toList());*//*
        return tposts.stream().map(TpostMapper::mapToTpostDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createYourPost(TpostDto tpostDto) {
        Tpost tpost = TpostMapper.mapToTpost(tpostDto);
        tpostRepository.save(tpost);
    }  // then after this handle the method

    @Override
    public TpostDto findPostById(Long tpostId) {
        Tpost tpost = tpostRepository.findById(tpostId).get();
        return TpostMapper.mapToTpostDto(tpost);
    }



    @Override
    public void updatePost(TpostDto tpostDto) {
        Tpost tpost = TpostMapper.mapToTpost(tpostDto);
        tpostRepository.save(tpost);

    }

    @Override
    public void deletePost(Long tpostId) {
        tpostRepository.deleteById(tpostId);
    }

    @Override
    public TpostDto findPostByUrl(String tpostUrl) {
        Tpost tpost = tpostRepository.findByUrl(tpostUrl).get(); // to get post object
        return TpostMapper.mapToTpostDto(tpost);
    }

    @Override
    public List<TpostDto> searchPosts(String query) {
        List<Tpost> tposts =tpostRepository.searchPosts(query);
        // convert list of posts entity to list of postDtos using stream
        return  tposts.stream()
                .map(TpostMapper::mapToTpostDto).
                collect(Collectors.toList());

    }

}*/

