:-ensure_loaded('RTIengine').
:-ensure_loaded('util.pl').

defrule gotox1
   if goto_x(Xf)  and x_is_at(Xi) and (Xi<Xf) and not(x_moving(1))
   then [
       assert( action(move_x_right))
   ].


defrule gotox2
   if goto_x(Xf)  and x_is_at(Xi) and (Xi>Xf) and not(x_moving(-1))
   then [
       assert( action(move_x_left))
   ].


defrule gotox3
   if goto_x(Xf) and x_is_at(Xf) and  not(x_moving(0))
   then [
       assert( action(stop_x)),
       retract(goto_x(Xf))
   ].


defrule gotoz_up
     if goto_z(Zf) and z_is_at(Zi) and (Zi<Zf) and not(z_moving(1))
     then [

         assert(sequence(
                    [
                       ( true,          assert(action(move_z_up))        ),
                       ( z_is_at(Zf),   (assert(action(stop_z)), retract_safe(goto_z(Zf)) )  )
                    ]
                ))
     ].


defrule gotoz_down
     if goto_z(Zf) and z_is_at(Zi) and (Zi>Zf) and not(z_moving(-1))
     then [
         assert(sequence(
                    [
                       ( true,         assert(action(move_z_down))       ),
                       ( z_is_at(Zf),  (assert(action(stop_z)),retract_safe(goto_z(Zf)) )     )
                    ]
                )),
         write(22222)
     ].






