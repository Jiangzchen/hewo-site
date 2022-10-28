
# 
## 
**URL:** `/user/create`

**Type:** `POST`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
data|object|No comments found.|false|-
└─id|string|No comments found.|false|-
└─username|string|No comments found.|false|-
└─password|string|No comments found.|false|-
└─email|string|No comments found.|false|-
└─mobile|string|No comments found.|false|-
└─status|int32|No comments found.|false|-
└─remark|string|No comments found.|false|-
└─userIdCreate|int64|No comments found.|false|-
└─gmtCreate|object|No comments found.|false|-
└─gmtModified|object|No comments found.|false|-


**Request-example:**
```
curl -X POST -i /user/create
```

**Response-example:**
```
{}
```

## 
**URL:** `/user/page`

**Type:** `POST`


**Content-Type:** `application/x-www-form-urlencoded;charset=utf-8`

**Description:** 



**Query-parameters:**

Parameter|Type|Description|Required|Since
---|---|---|---|---
data|string|No comments found.|false|-
page|int32|No comments found.|false|-
pageSize|int32|No comments found.|false|-


**Request-example:**
```
curl -X POST -i /user/page --data 'page=1&pageSize=10'
```

**Response-example:**
```
{}
```
