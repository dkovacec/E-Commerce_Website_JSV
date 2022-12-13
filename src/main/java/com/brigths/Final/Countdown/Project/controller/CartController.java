package com.brigths.Final.Countdown.Project.controller;

import com.brigths.Final.Countdown.Project.common.ApiResponse;
import com.brigths.Final.Countdown.Project.dto.AddToCartDto;
import com.brigths.Final.Countdown.Project.dto.CartDto;
import com.brigths.Final.Countdown.Project.model.User;
import com.brigths.Final.Countdown.Project.service.CartService;
import com.brigths.Final.Countdown.Project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    //@Autowired - not yet prepared
    //private AuthenticationService authenticationService;

    //post in a cart method
    @PostMapping("/cart/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token") String token) {

        //authenticate the token - not yet created method for authentication
        //authenticationService.authenticate(token);

        //not yet created method for authentication
        //User user = authenticationService.getUser(token);

        //missing authentication - waiting for authentication
        //cartService.addToCart(addToCartDto, user );

        return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

    }


    //get all products user put in a cart
    @GetMapping("/cart")
    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) {
        // authenticate the token - not yet created method for authentication
        //authenticationService.authenticate(token);

        // find the user - not yet created method for authentication
        //User user = authenticationService.getUser(token);

        // get products in a cart - waiting for authentication
        //CartDto cartDto = cartService.listCartItems(user);
        //return new ResponseEntity<>(cartDto, HttpStatus.OK);
        return null;
    }

    //delete product from cart
    @DeleteMapping("/cart/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Integer itemId,
                                                      @RequestParam("token") String token) {

        // authenticate the token - - not yet created method for authentication
        //authenticationService.authenticate(token);

        // find the user - not yet created method for authentication
        //User user = authenticationService.getUser(token);

        //waiting for authentication
        //cartService.deleteCartItem(itemId, user);

        return new ResponseEntity<>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);

    }
}
