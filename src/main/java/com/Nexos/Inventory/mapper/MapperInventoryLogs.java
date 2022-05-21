package com.Nexos.Inventory.mapper;

import com.Nexos.Inventory.model.Inventory;
import com.Nexos.Inventory.model.InventoryLog;
import com.Nexos.Inventory.model.Person;
import com.Nexos.Inventory.request.RequestInventoryLogs;

public interface MapperInventoryLogs {
    InventoryLog createInventoryLogs(RequestInventoryLogs requestInventoryLogs, Inventory inventory);

}
