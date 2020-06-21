package com.example.ecom.dbjson;

import com.example.ecom.dto.BookmarkDTO;
import com.example.ecom.dto.UserDTO;
import com.example.ecom.dto.UserviewDTO;
import com.example.ecom.entity.BookmarkEntity;
import com.example.ecom.entity.UserEntity;
import com.example.ecom.entity.UserView;
import com.example.ecom.entity.UserViewEntity;
import com.example.ecom.jsonmapper.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DBJsonQueryService {

    @Autowired
    DBJsonQueryRepository dbJsonQueryRepository;

    @Autowired
    JsonMapper jsonMapper;

    public List<UserviewDTO> getDemos(
            UserViewSearch userViewSearch,
            int i) {

        DemoSpecification demoSpecification = new DemoSpecification(
                userViewSearch
        );

        //Page<UserView> sss = dbJsonQueryRepository.findAll(PageRequest.of(0, 1));
        final PageRequest pageRequest = PageRequest.of(0, i);
        Page<UserView> sss = dbJsonQueryRepository.findAll(
                demoSpecification,
                pageRequest
        );
/*        Page<UserView> sss = dbJsonQueryRepository.findView(
                name,
                email,
                bookName,
                pageRequest
        );*/
        //Page<Userview> sss = userRep1.findByJsonbLastName(PageRequest.of(0, 1));

        List<UserView> content = sss.getContent();
        List<UserViewEntity> userViewEntityList = content.stream()
                .map(userView -> {
                    UserEntity userEntity = jsonMapper.stringToObject(
                            userView.getTest(),
                            UserEntity.class
                    );
                    UserViewEntity userviewEntity = new UserViewEntity();
                    userviewEntity.setUserEntity(userEntity);
                    userviewEntity.setUuid(userView.getPartId());
                    return userviewEntity;
                })
                .collect(Collectors.toList());

        List<UserviewDTO> collect = userViewEntityList.stream()
                .map(userViewEntity -> {

                    UserEntity userEntity = userViewEntity.getUserEntity();
                    List<BookmarkEntity> userEntityBooks = userEntity.getBooks();
                    List<BookmarkDTO> bookmarkDTOS = userEntityBooks.stream()
                            .map(bookmarkEntity -> {
                                BookmarkDTO bookmarkDTO = new BookmarkDTO();
                                bookmarkDTO.setId(bookmarkEntity.getId());
                                bookmarkDTO.setName(bookmarkEntity.getName());
                                bookmarkDTO.setUrl(bookmarkEntity.getUrl());
                                bookmarkDTO.setUserId(bookmarkEntity.getUserId());
                                return bookmarkDTO;
                            })
                            .collect(Collectors.toList());
                    UserDTO userDTO = new UserDTO();
                    userDTO.setBooks(bookmarkDTOS);
                    userDTO.setId(userEntity.getId());
                    userDTO.setEmail(userEntity.getEmail());
                    userDTO.setName(userEntity.getName());

                    UserviewDTO userviewDTO = new UserviewDTO();
                    userviewDTO.setUserDTO(userDTO);
                    userviewDTO.setUuid(userViewEntity.getUuid());
                    return userviewDTO;
                })
                .collect(Collectors.toList());
        return collect;

    }

}
