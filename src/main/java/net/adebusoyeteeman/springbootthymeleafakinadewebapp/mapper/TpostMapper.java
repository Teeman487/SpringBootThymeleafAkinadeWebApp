package net.adebusoyeteeman.springbootthymeleafakinadewebapp.mapper;

import net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto.TpostDto;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.entity.Tpost;

import java.util.stream.Collectors;
// Intention here is to convert
public class TpostMapper {

    // map Tpost entity to TpostDto
    public static TpostDto mapToTpostDto(Tpost tpost){
        // PostDto  postDto = PostDto.builder()
        return TpostDto.builder()
                .id(tpost.getId())
                .projectTitle(tpost.getProjectTitle())
                .url(tpost.getUrl())
                .content(tpost.getContent())
                .adebusoyeBriefContent(tpost.getAdebusoyeBriefContent())
                .createdOn(tpost.getCreatedOn())
                .updateOn(tpost.getUpdateOn())
                .comments(tpost.getComments().stream()
                        .map(comment -> CommentMapper.mapToCommentDto(comment))
                                .collect(Collectors.toSet()))


                .build();
        //return postDto;
    }

    // MAP TpostDto to Tpost entity
    public static Tpost mapToTpost(TpostDto tpostDto) {
        return Tpost.builder()
                .id(tpostDto.getId())
                .projectTitle(tpostDto.getProjectTitle())
                .url(tpostDto.getUrl())
                .content(tpostDto.getContent())
                .adebusoyeBriefContent(tpostDto.getAdebusoyeBriefContent())
                .createdOn(tpostDto.getCreatedOn())
                .updateOn(tpostDto.getUpdateOn())
                .build();
    }
}