package auxiliary.service;

import auxiliary.exception.CustomRuntimeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

import static auxiliary.util.LogicUtil.getRemFromDivByTwo;
import static java.util.Objects.isNull;

@Service
public class AuxiliaryService {

    @Value("${auxiliary.level.int}")
    private Integer intLevel;

    private ConcurrentHashMap<Integer, Boolean> permissionMap = new ConcurrentHashMap<>();

    public Boolean getById(Integer id) {
        checkKey(id);
        return permissionMap.get(id);
    }

    public void add(Integer id) {
        if (isNull(id)) {
            throw new CustomRuntimeException("id cannot be null");
        } else if (permissionMap.containsKey(id)) {
            throw new CustomRuntimeException(String.format("Such id = %s already exists!", id));
        }
        permissionMap.put(id, getRemFromDivByTwo(id));
    }

    private void checkKey(Integer id) {
        if (isNull(id)) {
            throw new CustomRuntimeException("id cannot be null");
        } else if (!permissionMap.containsKey(id)) {
            throw new CustomRuntimeException(String
                    .format("Permission with such id = %s not found", id));
        }
    }
}
