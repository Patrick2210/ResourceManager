package com.szaruga.myapp.service;

import com.szaruga.myapp.dao.ItemsRepository;

import com.szaruga.myapp.entity.Items;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ItemsServiceTest {

    @Mock
    private ItemsRepository itemsRepository;

    @InjectMocks
    private ItemsServiceImpl itemsService;
    private Items item;
    private Items itemTwo;


    @BeforeEach
    public void setup() {
        itemsRepository = Mockito.mock(ItemsRepository.class);
        itemsService = new ItemsServiceImpl(itemsRepository);
        item = new Items.Builder()
                .id(1)
                .itemName("Resources 1")
                .creationDate(LocalDateTime.of(2023, 7, 18, 10, 30))
                .modificationDate(LocalDateTime.of(2023, 7, 18, 15, 45))
                .ownerId(1)
                .objectType("MAP")
                .metaData("\"latitude\": 40.7128, \"longitude\": -74.0060, \"zoom_level\": 12")
                .build();

        itemTwo = new Items.Builder()
                .id(2)
                .itemName("Resources 2")
                .creationDate(LocalDateTime.of(2023, 7, 17, 14, 20))
                .modificationDate(LocalDateTime.of(2023, 7, 17, 16, 30))
                .ownerId(2)
                .objectType("FILE")
                    .metaData("\"file_name\": \"document.txt\", \"file_size\": \"10 KB\", \"file_type\": \"text/plain\"")
                .build();
    }

    @DisplayName("JUnit test for getAllItems method")
    @Test
    void givenItemsList_whenGetAllItems_thenReturnItemsList() {
        given(itemsRepository.findAll()).willReturn(List.of(item, itemTwo));
        List<Items> itemsList = itemsService.findAllItems();
        assertThat(itemsList).isNotNull();
        assertThat(itemsList.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for getAllItems method (negative scenario)")
    @Test
    void givenItemsList_whenGetAllItems_thenReturnEmptyItemsList() {
        given(itemsRepository.findAll()).willReturn(List.of(item, itemTwo));
        List<Items> membersList = itemsService.findAllItems();
        assertThat(membersList).isNotNull();
        assertThat(membersList.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for findItemsById method")
    @Test
    void givenItemsId_whenSaveItems_thenConfirmsNotNull() {
        int itemId = 1;
        given(itemsRepository.findById(itemId)).willReturn(Optional.of(item));
        Items saveItems = itemsService.findItemById(item.getId());
        assertThat(saveItems).isNotNull();
    }

    @DisplayName("JUnit test for saveItems method")
    @Test
    void givenItemsObject_whenSaveItems_thenReturnItemsObject() {
        given(itemsRepository.save(item)).willReturn(item);
        Items savedItem = itemsService.saveItem(item);
        assertThat(savedItem).isNotNull();
    }

    @DisplayName("JUnit test for deleteItemsById method")
    @Test
    void givenItemsId_whenDeleteItems_thenNothing() {
        int itemId = 1;
        willDoNothing().given(itemsRepository).deleteById(itemId);
        itemsService.deleteItemById(itemId);
        verify(itemsRepository, times(1)).deleteById(itemId);
    }
}