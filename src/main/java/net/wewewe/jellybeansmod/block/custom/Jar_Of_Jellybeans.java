package net.wewewe.jellybeansmod.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.stream.Stream;

public class Jar_Of_Jellybeans extends Block{
    public Jar_Of_Jellybeans(AbstractBlock.Settings settings){
        super(settings);
    }

    private static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(6, 0, 6, 10, 0, 10),
            Block.createCuboidShape(5, 0, 10, 6, 1, 11),
            Block.createCuboidShape(5, 0, 5, 6, 1, 6),
            Block.createCuboidShape(10, 0, 5, 11, 1, 6),
            Block.createCuboidShape(10, 0, 10, 11, 1, 11),
            Block.createCuboidShape(5, 8, 5, 6, 9, 6),
            Block.createCuboidShape(10, 8, 5, 11, 9, 6),
            Block.createCuboidShape(10, 8, 10, 11, 9, 11),
            Block.createCuboidShape(5, 8, 10, 6, 9, 11),
            Block.createCuboidShape(6, 9, 6, 10, 10, 10),
            Block.createCuboidShape(7, 10, 7, 9, 11, 9),
            Block.createCuboidShape(4, 1, 11, 5, 8, 12),
            Block.createCuboidShape(4, 1, 4, 5, 8, 5),
            Block.createCuboidShape(11, 1, 4, 12, 8, 5),
            Block.createCuboidShape(11, 1, 11, 12, 8, 12),
            Block.createCuboidShape(6, 0, 5, 10, 1, 6),
            Block.createCuboidShape(5, 0, 6, 6, 1, 10),
            Block.createCuboidShape(6, 0, 10, 10, 1, 11),
            Block.createCuboidShape(10, 0, 6, 11, 1, 10),
            Block.createCuboidShape(6, 8, 5, 10, 9, 6),
            Block.createCuboidShape(10, 8, 6, 11, 9, 10),
            Block.createCuboidShape(6, 8, 10, 10, 9, 11),
            Block.createCuboidShape(5, 8, 6, 6, 9, 10),
            Block.createCuboidShape(5, 1, 4, 11, 8, 5),
            Block.createCuboidShape(4, 1, 5, 5, 8, 11),
            Block.createCuboidShape(5, 1, 11, 11, 8, 12),
            Block.createCuboidShape(11, 1, 5, 12, 8, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
