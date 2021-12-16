We have to design a logistics system where a client can place an order to get his/her items delivered to a given destination .
We have to keep track of status of all the orders . The admin of logistics charges some amount for delivering the orders (Items).

- Customer
    - id
    - Address
    - 
    
- Item
    - id
    - weight
    - dimension
    - type
    
- Admin

- Vehicle

- Order
    - id
    - Customer sender
    - SourceAddress
    - String receiverName
    - DestinationAddress
    - Item List 
    - STATUS - {SCHEDULED_FOR_PICKUP, IN_TRANSIT, HOLD, DELIVERED}
    - PaymentDetails
    - DateOfTransaction

- PaymentDetail
    - PaymentType
    - PaymentStatus - {UNPAID, PAID}
    - TotalAmount
- PaymentType
    - Cash
    - DebitCard
    - CreditCard