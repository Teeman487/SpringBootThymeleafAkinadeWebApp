package net.adebusoyeteeman.springbootthymeleafakinadewebapp.service.Impl;

import jakarta.validation.Valid;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto.TpostDto;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.entity.Tpost;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.mapper.TpostMapper;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.repository.TpostRepository;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.service.TpostService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;
@Service   // this annottaion indicates that TpostServiceImpl is a spring service class,

public class TpostServiceImpl implements TpostService {

    private TpostRepository tpostRepository;

    public TpostServiceImpl(TpostRepository tpostRepository) {
        this.tpostRepository = tpostRepository;
    }

    @Override
    public List<TpostDto> findAllPosts() {
        List<Tpost> tposts = tpostRepository.findAll();
        /*return tposts.stream().map((tpost) -> TpostMapper.mapToTpostDto(tpost))
                .collect(Collectors.toList());*/
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

}

