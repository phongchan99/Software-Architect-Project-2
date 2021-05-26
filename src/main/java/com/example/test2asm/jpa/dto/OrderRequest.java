package com.example.test2asm.jpa.dto;

import com.example.test2asm.entity.OOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {

    private OOrder OOrder;
}
