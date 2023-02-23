package com.dmainali.jdbcdemo;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemException extends RuntimeException{
    String errorCode;
    String message;
    Throwable t;
}
