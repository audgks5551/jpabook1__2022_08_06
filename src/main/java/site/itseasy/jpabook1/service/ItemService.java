package site.itseasy.jpabook1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.itseasy.jpabook1.domain.Item;
import site.itseasy.jpabook1.dto.ItemDto;
import site.itseasy.jpabook1.repository.ItemRepository;

import java.util.List;

import static site.itseasy.jpabook1.mapper.ItemMapper.itemMapper;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public ItemDto saveItem(ItemDto itemDto) {
        Item item = itemMapper.toEntity(itemDto);
        Item savedItem = itemRepository.save(item);
        return itemMapper.toDto(savedItem);
    }

    public List<ItemDto> findItems() {
        List<Item> items = itemRepository.findAll();

        return itemMapper.toListDto(items);
    }

    public ItemDto findOne(Long itemId) {
        Item item = itemRepository.findOne(itemId);

        return itemMapper.toDto(item);
    }
}
