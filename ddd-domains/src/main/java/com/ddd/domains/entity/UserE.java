package com.ddd.domains.entity;

import com.ddd.types.ids.RepId;
import com.ddd.types.ids.UserId;
import com.ddd.types.valueobject.Address;
import com.ddd.types.valueobject.Name;
import com.ddd.types.valueobject.PhoneNumber;

/**
 * Created by wubo15 on 2021/3/1.
 *
 * @author wubo15
 * @date 2021/3/1
 */
public class UserE {

    UserId userId;

    Name name;

    PhoneNumber phone;

    Address address;

    RepId repId;
}
